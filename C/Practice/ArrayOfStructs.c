#include <stdio.h>
#include <string.h>
#define MAX_GRADES 10

typedef struct{
    char studentName[50];
    int studentGrades[MAX_GRADES];
    float studentAverage;
    int studentMinGrade, studentMaxGrade;

}Student;

float getAverage(int grades[], int size);
int getMinGrade(int grades[], int size);
int getMaxGrade(int grades[], int size);
void sortObjArr(Student students[], int size);

void clearInputBuffer();

int main(){

    int numberSize, numOfGrades, studGrade;
    char studName[50];
    int arrSize;


    printf("\nNumber of Students: ");
    scanf("%d", &numberSize);

    Student students[numberSize];

    printf("\nNumber of grades per student: ");
    scanf("%d", &numOfGrades);
    clearInputBuffer();



    for(int i = 0; i< numberSize; i++){
        printf("\nName of Student: ");
        fgets(studName, 50, stdin);
        studName[strlen(studName)-1] = '\0';

        strcpy(students[i].studentName, studName);


        for(int j =0; j < numOfGrades; j++){
            printf("Enter grade #%d: ", (j+1));
            scanf("%d", &studGrade);
            students[i].studentGrades[j] = studGrade;
            clearInputBuffer();

        }

        students[i].studentAverage = getAverage(students[i].studentGrades, numOfGrades);
        students[i].studentMinGrade = getMinGrade(students[i].studentGrades, numOfGrades);
        students[i].studentMaxGrade = getMaxGrade(students[i].studentGrades, numOfGrades);



    }



    printf("\nStudents sorted from highest average to lowest\n");
    sortObjArr(students, numberSize);
    for(int i =0; i < numberSize; i++){
        printf("Name: %s\t   Average: %.2f   Min: %d   Max: %d\n", students[i].studentName,students[i].studentAverage,students[i].studentMinGrade, students[i].studentMaxGrade); 

    }

    return 0;
}

void sortObjArr(Student students[], int size){
    Student temp;
    for(int i =0; i < size -1; i++){
        for(int j = i +1; j < size; j++){
            if(students[i].studentAverage < students[j].studentAverage){
                temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
    }
}
float getAverage(int grades[], int size){
    int sum = 0;
    for(int i = 0; i < size; i++){
        sum += grades[i];
    }
    return (float) sum/size;
}
int getMinGrade(int grades[], int size){
    int min = 100;
    for(int i =0; i< size; i++){
        if(min > grades[i]){
            min = grades[i];
        }
    }
    return min;
}

int getMaxGrade(int grades[], int size){
    int max = 0;
    for(int i =0; i< size; i++){
        if(max < grades[i]){
            max = grades[i];
        }
    }
    return max;
}




void clearInputBuffer(){
    int num;
    while((num = getchar()) != '\n' && num != EOF);
}