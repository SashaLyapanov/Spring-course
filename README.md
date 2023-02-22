# Maven Project with Hibernate And Entity Relation Many To One
В данном проекте реализована связь между сущностями Один ко многим.
В Hibernate это реализуется посредством использования аннотиций:
На дочерней сущности (которая Many): @ManyToOne, @JoinColumn(name = "columnName", referencedColumnName = "column name in main entity")
                                     private Person owner;
                                     
На главной сущности (которая One): @OneToMany(mappedBy = "название поля, в дочерней сущности (owner)")
                                   private List<Item> items; 
