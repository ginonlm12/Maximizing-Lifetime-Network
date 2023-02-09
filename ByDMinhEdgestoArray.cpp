#include<stdio.h>
int main(){
    int n;
    printf("Nhap so cua dinh lon nhat n: "); scanf("%d", &n);
    int a[100][100];
    int i,j;
    

    for(i=0;i<=n;i++){
        printf("Nhap cac dinh ke voi %d ",i);
        scanf("%d",&j);
        while(j<n+1){
            a[i][j]=1;
            scanf("%d",&j);
            printf(" ");
        }
        printf("\n");
    }

    for(i=0;i<=n;i++)
     for(j=0;j<=n;j++)
      {
        if((a[i][j]==1) || (a[j][i]==1)) {a[i][j]=1;a[j][i]=1; } else { a[j][i]=0; a[i][j]=0;};
      }
        for(i=0;i<=n;i++)
     {
        printf("{");
        for(j=0;j<n;j++)
         {
            printf("%d, ",a[i][j]);
         }
         printf("%d},\n",a[i][j]);
     }
    
}