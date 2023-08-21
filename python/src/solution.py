from src.point import Direction,Point

class Solution:
    _start = None
    _end = None
    _start_direction = None
    
    def __init__(self):
        self._start = Point()
        self._end = Point()
        self._start_direction = Direction()
    
    @property
    def start(self):
        return self._start
    @start.setter
    def start(self, value: Point):
        self._start = value
    
    @property
    def end(self):
        return self._end
    @end.setter
    def end(self,value:Point):
        self._end = value
    
    @property
    def start_direction(self):
        return self._start_direction
    @start_direction.setter
    def start_direction(self, value:Direction):
        self._start_direction = value
    
    def makeStartPoint(self, point_x:int, point_y:int):
        self.start.x = point_x
        self.start.y = point_y
    
    def makeEndPoint(self,point_x:int,point_y:int):
        self.end.x = point_x
        self.end.y = point_y
    
    def makeStartDirection(self,direct:str):
        self.start_direction.direction = direct

    def calculate_power(self):
        STEP_POINT = 10
        TURN_POINT = 5
        STARTING_POWER = 200
        
        dx = self.end.x - self.start.x
        dy = self.end.y - self.start.y
        abs_dist = abs(dx) + abs(dy)
        
        turn_dist = self.start_direction.calc_turns(dx, dy)
        
        distance = STARTING_POWER - ( abs_dist * STEP_POINT + turn_dist * TURN_POINT)

        print('POWER', distance)
        return