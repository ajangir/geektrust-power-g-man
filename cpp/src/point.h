#ifndef POINT_H
#define POINT_H
class Point 
{
    private:
        int _x;
        int _y;

    public:
        Point(int a = 0, int b = 0) : _x(a), _y(b) {}

        int getX() const {
            return _x;
        }

        void setX(int a) {
            _x = a;
        }

        int getY() const {
            return _y;
        }

        void setY(int b) {
            _y = b;
        }
};
#endif // POINT_H