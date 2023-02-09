#include<stdio.h>
int main(){
    int n;
    printf("Nhap vao so nguyen n:"); scanf("%d",&n);
    int Graph[n][n];
    int i,j;
    for(i=0;i<n;i++){
        for(j=1;j<n;j++){
            Graph[i][j]=0;
        }
    }
    for(i=0;i<n;i++){
        printf("Nhap vao dinh dau tien noi voi i=%d:",i); scanf("%d",&j);
        while(j<20){
            Graph[i][j]=1;
            scanf("%d",&j);
            printf(" ");
        }
    }
    for(i=0;i<n;i++){
        printf("{");
        for(j=1;j<n;j++){
            printf("%d, ", Graph[i][j]);
        
        }
        printf("},");
        printf("\n");
    }
}