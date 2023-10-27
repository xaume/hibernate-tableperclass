# Hibernate 6 inheritance issue
The project contains two entities:
* Parent
* Child
  
Child inherits from Parent, and Parent uses inheritance strategy `InheritanceType.TABLE_PER_CLASS`,
which requires a database table per child entity, with all the fields from the parent, plus the additional
fields from the child.

After migrating from Spring Boot 2 to Spring Boot 3, and hence to Hibernate 6, I identified the following issue:

1. Create a new instance of `Child` with default values
2. Modify one attribute of `Child` via a member function
3. Save the `Child` entity
4. The entry is saved with the original value, not the modified one

In step number 2, after modifying the attribute, this is only changed for the `Child`, but not for the `Parent`.

![image](https://github.com/xaume/hibernate-tableperclass/assets/5335451/a6fa97a9-f879-4541-8550-79890f1e0e18)


Apparently, when Hibernate saves the entity, it's taking the value from the `Parent` instead of the value from the `Child`.
This didn't happen with Spring Boot 2.x + Hibernate 5.x
