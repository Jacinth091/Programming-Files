#include <stdio.h>

int main()
{
    int num[] = {2,8,3,2,4,5,6,7,9,10,23,1,10,10,2,8,3,2,4,5,6,7,9,10,23,1,10,10};
    int temp = 0, duplicate =0;
    int dupeNum[sizeof(num) / sizeof(num[0])] = {0};
    
    // Insertion Sort Alogrithm =======================================
    for(int i =1; i < sizeof(num) / sizeof(num[0]); i++){
        int j =i;
        while(j>0 && num[j-1] > num[j]){

            temp = num[j];
            num[j] = num[j-1];
            num[j-1] = temp;
            j--;
        }
    }
    // Searching Through the Array for Duplicates and Putting them in dupeNum ARRAY =======================================

    printf("Sorted Array: ");
    for(int i =0; i<sizeof(num)/ sizeof(num[0]); i++){
        // int j =i;
        if(i >0 && num[i]==num[i-1]){
            
            if(dupeNum[num[i]] == 0){
                dupeNum[num[i]] = num[i-1];
                duplicate++;
            }
        }
        printf("%d ", num[i]);
    }
    printf("\n\n");

    // Displaying the duplicate number and the number of unique dupe numbers =======================================

    printf("Duped Numbers: ");  
    for(int i =1; i<sizeof(dupeNum)/ sizeof(dupeNum[0]); i++){
        if(dupeNum[i] != 0){
            printf("%d ", dupeNum[i]);
        }
        // printf("%d ", dupeNum[i]);
    }
    
    printf("\nDuplicate Numbers: %d", duplicate);
    

    return 0;
}