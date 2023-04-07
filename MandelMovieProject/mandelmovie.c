#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <math.h>

int main(int argc, char **argv){

    int fileNum = 0;
    double scaleVal = 2;
    char fileName[20] = "-omandel0.bmp";
    char scale[] = "-s2.00";
    char nameConverter[50];
    char scaleConverter[50];
    int processes = 1;
    double temp = 0;
    
    //If the user input an argument
    if(argc == 2){
    	processes = atoi(argv[1]);
    	printf("%d processes\n", processes);
    }

    //Number of times to start processes simultaneously
    int loops = 50 / processes;

    //accounting for input that doesnt split 50 evenly
    if(50 % processes != 0){
	loops++;
    }

    for(int i = 0; i < loops; i++){

        //forking for every processes
        for(int j = 0;j  < processes; j++){

            int pid = fork();

            if(pid == 0){

                //incrementing name of file
	            fileNum++;

                //accounting for input hat doesnt split 50 evenly
		        if(fileNum == 50){
			        break;
		        }

                sprintf(nameConverter,"%d.bmp",fileNum); 
                
                strcpy(&fileName[8], nameConverter);

                //Changing the scale for each file using an equation
		        temp = log(.1);
		        temp = temp / 49;
		        temp = exp(temp);
	            scaleVal = scaleVal * temp;

                sprintf(scaleConverter,"%.2f",scaleVal);

                strcpy(&scale[2], scaleConverter);

            }
            else{
                
                //running mandel process
                execl("mandel","mandel", "-x-.38","-y-.665",fileName, scale, "-n4",NULL);
                printf("errno = %s\n",strerror(errno));
            }

        }

        //waiting for processes to conclude
        wait(NULL);


    }


}
