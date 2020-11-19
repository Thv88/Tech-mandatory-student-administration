package com.adm.studentadministration.repositories;

import com.adm.studentadministration.models.Student;

import java.util.List;

public interface IStudentRepository {
    // CRUD operations
    public boolean create(Student student);

    public Student read(int id);

    public List<Student> readAll();

    public boolean update(Student student);

    public boolean delete(int id);
}


