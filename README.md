#CRUDwithJSBC_API
В данной ветке располагается проект, демонстрирующий работу с JDBC Template. Данную технологию предоставляет Spring Framework, как обертку над JDBC API. С помощью JDBC Template мы избавляемся от минусов JDBC API, что позволяет нам уменьшить количество кода и избавиться от повторяющегося кода.
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
