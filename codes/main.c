#include <stdio.h>
#include <stdlib.h>

int main()
{
    double L,sections,W,Ldis,Cdis,C,Area,A1,B1,C1,B,A;
    int i,choice;
    double p1 = 0;
    double p2 = 0;

    double q1 = 0;
    double q2 = 0;

    double r1 = 0;
    double r2 = 0;

    printf("Enter length of beam: ");
    scanf("%lf", &L);

    printf("Enter number of sections between A and B: ");
    scanf("%lf", &sections);

    printf("Choose a load type from the below list:\nType 1:Uniformly distributed load\nType 2:Triangular load-left to right\nType 3:Triangular load-right to left\n");


    for(i = 1;i<=sections;i++){

        printf("Choose section %d's load type: ",i);
        scanf("%d", &choice);

        printf("Enter load on the section: ");
        scanf("%lf", &W);

        printf("Enter the distance from point 'A': ");
        scanf("%lf", &Ldis);

        printf("Enter the length of the section: ");
        scanf("%lf", &Cdis);

        if(choice == 1){

            C = Cdis/2;
            Area = Cdis*W;
            A1 = Area*(C + Ldis);
            p1 = p1+Area;
            p2 = p2+A1;

        }
        else if(choice == 2){

            C = 0.666*Cdis;
            Area = 0.5*Cdis*W;
            B1 = Area*(C + Ldis);
            q1 = q1+Area;
            q2 = q2+B1;

        }
        else if(choice == 3){

            C = 0.333*Cdis;
            Area = 0.5*Cdis*W;
            C1 = Area*(C + Ldis);
            r1 = r1+Area;
            r2 = r2+C1;

        }

    }

    B = (p2+q2+r2)/L;
    A = (p1+q1+r1) - B;

    printf("The reaction force at A is %f\n", ceil(A));
    printf("The reaction force at B is %f\n", ceil(B));

    return 0;
}
