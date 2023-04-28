# Occidental Mindoro State College Online student information and management system

![Cover](image\Cover.jpg)

--------

The Occidental Mindoro State College Online student information and management system is a web-based tool designed to provide students, faculty, and staff with real-time access to academic and personal information. The system allows students to view and update their enrollment data, personal information, education background, employment records, and medical information, as well as track their progress towards meeting degree requirements. In addition, the system provides access to online tasks, modules, and attendance records. The system streamlines administrative tasks and facilitates communication between students, faculty, and staff, enhancing the academic experience for all stakeholders.

*Table of Contents*
===================
* [Title](#occidental-mindoro-state-college-online-student-information-and-management-system)
* [Table of Contents](#table-of-contents)
  * Description
* [Introduction](#introduction)


# introduction
The Occidental Mindoro State College Online student information and management system is an innovative tool designed to enhance the academic experience of students, faculty, and staff. As educational institutions become increasingly reliant on technology, it is important to develop systems that can effectively manage student information, streamline administrative tasks, and provide real-time access to data. In this research paper, we aim to evaluate the effectiveness of the Occidental Mindoro State College Online student information and management system, and examine its impact on various stakeholders.

We will begin by providing a comprehensive overview of the system, including its features and functionalities. We will also examine the existing literature on online student information and management systems, and identify best practices and key success factors. We will then describe our research methodology, which will involve a survey of students, faculty, and staff to gather their feedback and opinions on the system. We will also collect data on system usage and performance, and conduct a comparative analysis of the system's performance against established benchmarks.

The results of this study will provide valuable insights into the effectiveness of the Occidental Mindoro State College Online student information and management system, and its impact on various stakeholders. We hope that this research will contribute to the ongoing dialogue on the role of technology in education, and inform the development of future systems and practices in this field.

# Obecjecives
- To provide students with easy access to their academic and personal information, such as enrollment data, education background, and contact information.
- To streamline administrative tasks and processes, such as enrollment management, record keeping, and grading.
- To enhance communication and collaboration between students, faculty, and staff through online tasks, modules, and messaging.
- To improve student engagement and performance through real-time tracking of attendance records, online task submissions, and module completion.
- To provide instructors with a comprehensive tool for managing course content, including readings, lectures, assignments, and exams.
- To improve the accuracy and security of student data by providing a centralized and secure database.
- To reduce paper-based processes and promote sustainability through online record keeping and communication.
- To continuously evaluate and improve the system based on feedback from students, faculty, and staff, and industry best practices.

# Features
### **Administrative**
### **Instructor**
### **Student**
- **Enrollment Data**: Students can view their enrollment status, courses enrolled, and any fees or charges.
- **Personal Information**: Students can view and update their personal information, such as name, date of birth, gender, and contact information.
- **Addresses & Contacts**: Students can view and update their mailing address and contact details.
- **Education Background**: Students can view their educational history, including degrees earned and transcripts.
- **Medical Info**: Students can view any medical information that has been submitted, such as allergies, disabilities, and emergency contacts.
- **Employment Records**: Students can view any employment records, such as work-study or on-campus employment.
- **Online Tasks**: Students can view any online tasks assigned by their instructors, such as assignments, quizzes, or discussion forums.
- **Modules**: Students can view the modules for each course they are enrolled in, including readings, lectures, and assignments.
- **Absences**: Students can view their attendance records for each course, including absences and tardiness.
- **Curriculum Evaluation**: Students can view their progress towards meeting degree requirements, including required courses and electives.
### **Parent**
### **Admissions**

# **Building**
You need to make sure that you have [JDK 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html) or [JDK 20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html) Else it will not work

## Members & Roles
--------

- Nicholas John C. Abeleda (Head Programmer)
- Chris La Rosa (Sub-Programmer)
- Treasee May Estefanio (Graphics Designer)
- Mark Anthony Rosete (Graphics Designer)
- Edriel Begornia (Researcher) 
- Curt David Tibayan Gamil (Researcher)
- Brylle Darren Ramos (Researcher)
- Thaddeus Embanecido Binasag (Researcher) 
- James Dwight Jimenez Aban (Researcher) 
- Jaztin Gaytano (Researcher)
- Justine Noble Costales (Researcher) 
- Mark Del Mundo (Paper Works)
- Mayrine Balanon Francisco Balan (Paper Works) 
- Devon Pajaro (Paper Works)
- RaChelle Bade Tan (Paper Works)
- Tiegie Salazar Estabillo (Paper Works)
- Rj Bangsoy Bical (Paper Works)

- Vhalerey Jaravata (Paper Works)
- Wendy Alerta (Paper Works)
## File data structure

--------

```css
Final_Project/
├── Data/
│   ├── MidtermExam/
│   │   ├── Answers.txt
│   │   ├── Answers1.txt
│   │   ├── Choice.txt
│   │   ├── Choice1.txt 
│   │   └── Questions.txt
│   ├── Accounts.txt
│   └── InsAccounts.txt
│   
├── image/
│   ├── Cover.jpg
│   └── Icon.png
│
├── Main/
│   ├── Activities/
│   ├── Exam/
│   │   ├── ExamMenu.java
│   │   └── JavaExam/
│   ├── Quizes/
│   ├── AdminLoginForm.java
│   ├── InstructorLoginForm.java
│   ├── MainMenu.java
│   ├── ParentLoginForm.java
│   ├── StudentLoginForm.java
│   └── StudentRegisterForm.java
│
├── Sub/
│   ├──Table/
│   │   ├── ClassAbs.java
│   │   ├── CurriculumEvaluation.java
│   │   ├── EnrolledSub.java
│   │   ├── Modules.java 
│   │   └── OnlineTask.java
│   ├── Loading.java
│   ├── Paint.java
│   ├── Questions.java
│   └── SciCal.java
│    
├── .env
├── Main.java
└── README.md

```

## Sequence Diagram

----------                    
              
```seq
Main.java ->> Loading.java: Open
    Loading.java ->> MainMenu.java: Open
    MainMenu.java ->> AdminLoginForm.java: Click
    AdminLoginForm.java ->> Data/Accounts.txt: Access
    AdminLoginForm.java ->> Data/InsAccounts.txt: Access
    AdminLoginForm.java ->> image/Cover.jpg: Access
    AdminLoginForm.java ->> image/Icon.png: Access
    MainMenu.java ->> InstructorLoginForm.java: Click
    InstructorLoginForm.java ->> Data/Accounts.txt: Access
    InstructorLoginForm.java ->> Data/InsAccounts.txt: Access
    InstructorLoginForm.java ->> image/Cover.jpg: Access
    InstructorLoginForm.java ->> image/Icon.png: Access
    MainMenu.java ->> ParentLoginForm.java: Click
    ParentLoginForm.java ->> Data/Accounts.txt: Access
    ParentLoginForm.java ->> Data/InsAccounts.txt: Access
    ParentLoginForm.java ->> image/Cover.jpg: Access
    ParentLoginForm.java ->> image/Icon.png: Access
    MainMenu.java ->> StudentLoginForm.java: Click
    StudentLoginForm.java ->> Data/Accounts.txt: Access
    StudentLoginForm.java ->> Data/InsAccounts.txt: Access
    StudentLoginForm.java ->> image/Cover.jpg: Access
    StudentLoginForm.java ->> image/Icon.png: Access
    StudentLoginForm.java ->> Table/ClassAbs.java: Access
```
