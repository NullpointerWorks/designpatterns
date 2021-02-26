#include <iostream>
#include <math.h>

using std::cout;
using std::endl;

/*
	define two classes that describe some funcitonality. in this example, a round thingy that has to fit in a round hole.
*/
class RoundThing
{
	float radius;
public:
	RoundThing(float r)
	{
		radius = r;
	}

	virtual float getRadius()
	{
		return radius;
	}
};

class RoundInterface
{
	float diameter;

public:

	RoundInterface(float d)
	{
		diameter = d;
	}

	~RoundInterface() {}

	bool isCompatible(RoundThing round)
	{
		float rad = round.getRadius() * 2;
		return rad <= diameter;
	}

};

/*
	next, a class that's not designed to work with the RoundInterface class
	how do make this class compatible with round interface?
*/
class RectangularThing
{
	float width;
	float height;

public:
	RectangularThing(float w, float h)
	{
		width = w;
		height = h;
	}

	virtual float getWidth()
	{
		return width;
	}

	virtual float getHeight()
	{
		return height;
	}
};

/*
	we define an adapter that inherits the functionality of the thing class that's compatible. (RoundThing in this example)
	take the rectangle class as an argument and extract some data. calculate its width and simulate it's radius.
*/
class RectToRoundAdapter: public RoundThing
{
	float radius;

public:
	RectToRoundAdapter(RectangularThing rect): RoundThing(0.0f)
	{
		float w = rect.getWidth();
		float h = rect.getHeight();
		float c2 = w * w + h * h;
		radius = sqrt(c2) * 0.5f;
	}

	virtual float getRadius() override
	{
		return radius;
	}
};

/*
	try it out
*/
int main()
{
	RoundInterface hole( 5.0f );
	RoundThing thingy1( 2.5f );

	if (hole.isCompatible(thingy1))
	{
		cout << "fits!\n";
	}
	else
	{
		cout << "doesn't fit\n";
	}

	RectangularThing thingy2(2.0f, 3.0f);
	RectToRoundAdapter adapter(thingy2);

	if (hole.isCompatible(adapter))
	{
		cout << "fits!\n";
	}
	else
	{
		cout << "doesn't fit\n";
	}
}
