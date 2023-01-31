#Batch Update
Batch Update - это технология, позволяющая выполнять пакетное обновление данных в БД. Имеется ввиду, что раньше мы могли добавлять данные в БД с помощью отдельных запросов на вставку конкретного объекта. Например ("INSERT INTO Person VALUES (?, ?, ?)", person.getId(), person.getName(), person.getSurname());. А если же нам надо было бы вставить большой объем данных (напирмер вставвка 1000 записей), то мы бы должны были выполнить 1000 транзакций к БД, что неправильно, т.к. это огромная нагрузка на сеть, а также затрата времени, т.к. БД не может распараллелить отдельные запросы. Так вот, Batch Update является способом вставки большого объема данных через 1 запрос. Для этого нам необходимо:
1) Создаем список, содержащий все объекты, которые хотим вставить в БД.
        
        List<Person> people = new ArrayList<>();
        
2) А далее пишем через PreparedStatement и объект класса JdbcTemplate!!!:
        
        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES(?,?,?)", new BatchPreparedStatement() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException{
                ps.setInt(1, people.get(i).getId());
                ps.setString(2, people.get(i).getName());
                ps.setString(3, people.get(i).getSurname());
            }
            
            @Override
            public int getBatchSize() {
                return people.size();
            }
        });


Также в данной ветке располагается проект, демонстрирующий работу с JDBC Template. Данную технологию предоставляет Spring Framework, как обертку над JDBC API. С помощью JDBC Template мы избавляемся от минусов JDBC API, что позволяет нам уменьшить количество кода и избавиться от повторяющегося кода.
Для работы с данной технологией нам необходимо сделать следующие вещи:
1) Докачать зависимость: spring-jdbc через pom.xml
2) в конфигурационном классе создать бин источника данных (DataSource), который будет возвращать объект со всеми данными для подключения к БД (Url, driverClass, username, password)
3) в конфигурационном классе создать бин jdbcTemplate, возвращающий объект JdbcTemplate(dataSource())
4) в DAO классе выполнить создание объекта JdbcTemplate через конструктор
        Например: 
        @Component
        public class PersonDAO {

            private final JdbcTemplate jdbcTemplate;
            @Autowired
            public PersonDAO(JdbcTemplate jdbcTemplate) {
                this.jdbcTemplate = jdbcTemplate;
            }
5) используя методы .query или .update создать необходимые методы DAO шаблона
        Например:
        //Метод, возвращающий всех людей из БД
        
        public List<Person> index() {
            return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
        }
        
       //Метод добавления человека в список
       
        public void save(Person person) {
            // можно так написать, т.к. метод update поддерживает внесение множества аргументов, которые будут рассмотрены, как массив данных, которые неободимо вставить
            jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?, ?)", person.getName(), person.getSurname(), person.getAge(), person.getEmail());

        }

Также стоит отметить подключение к БД через конфигурационный файл, который называется database.properties (по факту его не надо было выкладывать на githab, но т.к. это учебный проект, то и таааак сойдет))) Кстати, этот файл на гите должен заменяться файлом database.properties.orogin, который передает чисто структуру и необходимые данные, но не дает конкретных данных. Необходимо сказать, что после создания данного файла нам необходимо внедрить данные в код (конфигурационный класс SpringConfig). Это мы делаем с помощью объекта класса Environment, который также инициализируем через конструктор класса:

PropertySource("classpath:database.properties")
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;
    private final Environment environment;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext, Environment environment) {
        this.applicationContext = applicationContext;
        this.environment = environment;
    }
    
А дальше при создании бина dataSource мы уже не вписываем напрямую данные для подключения к БД, а достаем данные из environment:
        
            @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("driver")));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("username_value"));
        dataSource.setPassword(environment.getProperty("password"));

        return dataSource;
    }
