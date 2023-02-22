# Maven Project with Hibernate
В данном проекте показано, как добавлять сущности в БД (сохранять) с помощью Hibernate. Причем используется автоинкремент для id.
Показано использование аннотаций @GeneratedValue(strategy = GenerationType.IDENTITY)
Также есть @GeneratedValue(strategy = GenerationType.SEQUENCE), которая используется, если при создании таблицы в БД не было указано, что поле автоинкрементируется. Также для этого необходимо при создании таблицы в БД создать для нее sequence, который связывается с полем в Java коде следующим образом:

@GeneratedValue(strategy = GenerationType.SEQUENCE,
                generator = "personId_sequence")
@SecuenceGenerator(name = "personId_sequence",
                   sequenceName = "person_seq",
                   allocationSize = 1)
private int id;
