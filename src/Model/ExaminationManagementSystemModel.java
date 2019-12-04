package Model;

import java.io.File;

public interface ExaminationManagementSystemModel
{
   void addExam(Exam exam);
   void removeExam(DateAndTimePeriod period);
   void addNewPeriodToTheFile(File file);
   void makePeriodFree(DateAndTimePeriod period);
   void addNewExamToTheSchedule(File file);
   void addNewRoomToTheRooms(File file);
   void addNewClassToTheClasses(File file);
   String AllExamsInString();
   void removeClassFromEveryWhere(String className);
   void addStudentToTheStudentList(File file);
   void removeStudentFromTheEveryWhere(int id);
   void addTeacherToTheTeacherList(File file);
   void removeTeacherFromEveryWhere(int id);

}
