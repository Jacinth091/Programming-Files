#include <stdio.h>
#include <string.h>


// struct Cars
// {
//     char color[50];
//     int year;
//     char name[50];
// };


typedef struct{
    char studentName[50];
    int idNumber;
    char studentCourse[25];

} Student;

void clearInputBuffer();
int main(){
    const int numberOfStudents = 2;
    Student students[numberOfStudents];

    char studentName[100];
    char studentCourse[100];
    int userInId;


    for(int i= 0; i < numberOfStudents; i++){
        printf("\nInput Student Name %d: ", (i+1));
        fgets(studentName, 100, stdin);
        studentName[strlen(studentName) -1] = '\0';

        strcpy(students[i].studentName, studentName);

        printf("\nInput Student Course %d: ", (i+1));
        fgets(studentCourse, 100, stdin);
        studentCourse[strlen(studentCourse) -1] = '\0';

        strcpy(students[i].studentCourse, studentCourse);

        printf("\nInput Student Id Number %d: ", (i+1));
        scanf("%d", &userInId);

        students[i].idNumber = userInId;
        clearInputBuffer();

    }

    for(int i =0; i< numberOfStudents; i++){
        printf("\nStudent: %d\n", (i+1));
        printf("\nStudent %d Name: %s\n", (i+1), students[i].studentName);
        printf("\nStudent %d Course: %s\n", (i+1), students[i].studentCourse);
        printf("\nStudent %d Id Number: %d\n", (i+1), students[i].idNumber);

    }
    






    // structs = collection of related members ("variables")
    //            they cn ve of different data types
    //           listed under one name in a block of memory
    //           VERY SIMILAR to classes in other languages (but no methods)

    // typedef =  reserved keyword thatgives an existing datatype a "nickname"


    // struct Cars carOne;
    // struct Cars carTwo;

    // strcpy(carOne.name, "Tesla");
    // carOne.year = 2021;
    // strcpy(carOne.color, "Midnight-Black");

    // printf("\nCar One");
    // printf("\nName: %s", carOne.name);
    // printf("\nYear: %d", carOne.year);
    // printf("\nColor: %s\n", carOne.color);

    // strcpy(carTwo.name, "Ferrari");
    // carTwo.year = 2023;
    // strcpy(carTwo.color, "Sun-Red");

    // printf("\nCar Two");
    // printf("\nName: %s", carTwo.name);
    // printf("\nYear: %d", carTwo.year);
    // printf("\nColor: %s\n", carTwo.color);
    


    return 0;
}

void clearInputBuffer(){
    int num;
    while((num = getchar()) != '\n' && num != EOF);
}