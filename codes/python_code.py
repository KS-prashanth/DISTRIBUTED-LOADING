L = int(input("Enter total distance from A to B: "))
sections = int(input("Enter total number of sections between A and B:" ))

print(" Load type1: uniformly distributed load\n", 
        "Load type2: Triangular load- Left to right\n", 
        "Load type3: Triangular load- Right to left\n")

x1,x2,y1,y2,z1,z2 = 0,0,0,0,0,0

for i in range(sections):
    
    choice = int(input("Choose your section " +str(i+1)+ "'s load type: "))
    W = int(input("Enter load acting on the section: "))
    Ldistance = int(input("Enter the distance from point A: "))
    Cdistance = int(input("Enter length of the section: "))
     
    if choice == 1:
        C = Cdistance/2;
        Area = Cdistance*W
        A2 = Area *(C + Ldistance)
        x1 += Area
        x2 += A2
    elif choice == 2:
        C = (2/3)*Cdistance
        Area = (1/2)*Cdistance*W
        B2 = Area * (C + Ldistance)
        y1 += Area
        y2 += B2
    elif choice == 3:
        C = (1/3)*Cdistance;
        Area = (1/2)*Cdistance*W
        D2 = Area * (C + Ldistance);
        z1 += Area
        z2 += D2


B = (x2 + y2 + z2)/L
print("The reaction force at B is: "+str(B))

A = (x1 + y1 + z1) - B
print("The reaction force at A is: "+str(A))
