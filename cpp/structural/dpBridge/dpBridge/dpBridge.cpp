/*
    image defining a set af shape objects that have various properties it can be tested on.
    instead of creating a class consisting of methods that test all it's properties,
    seperate those methods into new classes that group related code together.
    this creates order and maintainability.

    in other words, the bridge pattern is all about seperation of concerns.
    if you have a Shape class that has a boundary and a color you could make a group of classes 
    for each permutation.
    
    for example:
    - red circle
    - red rectangle
    - blue circle
    - blue rectangle

    imagine adding new shapes and colors. this list of classes grows exponentially. now introduce
    a completely new property. you need to make a new set of classes for each possible case of
    that property. this rapidly turns into a programmer's hell.

    turning the color and boundary into seperate classes that can be applied to a base Shape object
    reduces the code base significantly. 

*/
#include <iostream>

/*
    define a property for the color.
*/
class Color
{
    int RGB;
public:
    Color() { RGB = 0; }

    void setColor(int r, int g, int b)
    {
        RGB = r << 16 | g << 8 | b;
    }

    int getColor()
    {
        return RGB;
    }

};

/*
    define a common interface that contains a property to control the shape'outline
*/
class Boundary
{
public:
    virtual bool isInside(int x, int y) = 0;
};

class Rectangle :public Boundary
{
    int xP;
    int yP;
    int width;
    int height;

public:
    Rectangle(int x, int y, int w, int h)
    {
        xP = x;
        yP = y;
        width = w;
        height = h;
    }

    bool isInside(int x, int y) override
    {
        if (x < xP) return false;
        if (y < yP) return false;
        if (x > (xP + width)) return false;
        if (y > (yP + height)) return false;
        return true;
    }
};

/*
    define a shape with properties
*/
class Shape
{
    Boundary* boundary;
    Color color;

public:
    Shape(Boundary* bound, Color col)
    {
        boundary = bound;
        color = col;
    }

    /* ... implementation code here */
};

/*
    this demonstrates how such a new shape would be constructed
*/
int main()
{
    Color myColor;
    myColor.setColor(255, 0, 0);

    Rectangle myRectangle(100,100, 200, 50);

    Shape myShape(&myRectangle, myColor);


}
