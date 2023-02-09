#include <stdio.h>
int main(){
    int k=6,m=45;
    int l,r;
    int i,j;
    if (m%k==0) {
        l=m/k;
    } else l=m/k-1;
    
    
    for(j=0;j<l;j++){
        printf("(");
        for(i=k*j+1;i<=k*(j+1);i++){
            if(i!=k*(j+1)) printf("S%d,",i); else printf("S%d",i);
        }
        printf(") Tgian : 1 unit\n");
    }

    r=m-l*k;
    if(r!=0){
        int n=l*k+1;
        for(j=n;j<=m-k+1;j++)
         {
            printf("(");
            for(i=j;i<=j+k-1;i++)
             {
                
                if(i!=j+k-1) printf("S%d,",i); else printf("S%d",i);
             }
             printf(") Tgian : 1/%d unit\n",k);
         }

        for(j=m-k+2;j<=m;j++)
         {
            printf("(");
            for(i=j;i<j+k-1;i++)
             {
                
                if(i>m) printf("S%d,",i-m+n-1); else printf("S%d,",i);
             }
            i=j+k-1;
             if(i>m) printf("S%d",i-m+n-1); else printf("S%d",i);
             printf(") Tgian : 1/%d unit\n",k);
         }
    }


}