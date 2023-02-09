#include<stdio.h>
int main (){
    int n;
    printf("Nhap vao so nguyen n: "); scanf("%d", &n);
    int OGraph[n][n]; //Original Graph
    int i,j;
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            printf("Nhap vao gia tri OGraph[%d][%d]: ",i,j); scanf("%d", &OGraph[i][j]);
        }
    }

    int RGraph[2*n-2][2*n-2];//Rewritten Graph
    for(i=0;i<2*n-2;i++){
        for(j=0;j<2*n-2;j++){
            RGraph[i][j]=0;
        }
    }
    RGraph[0][0] = OGraph[0][0];
    for(i=1; i<n-1;i++){
        RGraph[0][2*i-1]= OGraph[0][i];
        //RGraph[0][2*i]= 0;
        //RGraph[2*i-1][0]= 0;
        //RGraph[2*i][0]= 0;
    }
    for(i=1; i<n-1;i++){
        //RGraph[2*n-3][2*i-1]=0;
        //RGraph[2*n-3][2*i]=0;
        RGraph[2*i][2*n-3]=OGraph[n-1][i];
    }
    for(i=1;i<n-1;i++){
        for(j=1;j<n-1;j++){
            if(i==j){
                RGraph[2*i-1][2*i]= 1;
                RGraph[2*i][2*i-1]= OGraph[i][i];
                //RGraph[2*i][2*i]= 0;
                //RGraph[2*i-1][2*i-1]= 0;
            }
            else {
                if(OGraph[i][j]==0){
                    //RGraph[2*i-1][2*j-1]=0;
                    //RGraph[2*i-1][2*j]=0;
                    //RGraph[2*i][2*j-1]=0;
                    //RGraph[2*i][2*j]=0;
                }
                else
                    RGraph[2*i][2*j-1]=OGraph[i][j];
                    //RGraph[2*j-1][2*i]=0;
            }
        }
    }
    for(i=0;i<2*n-2;i++){
        for(j=0;j<2*n-2;j++){
            printf("%d  ",RGraph[i][j]);
        }
        printf("\n");
    }
    return 0;
}