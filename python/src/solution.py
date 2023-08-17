from src.point import Point,Direction

class Solution:
    def __init__(self):
        self.start = Point()
        self.end=Point()
        self.d = Direction()
    
    def calculate_power(self):
        STEP_POINT = 10
        TURN_POINT = 5
        STARTING_POWER = 200
        if not self.start and not self.end and not self.d:
            print('not initialized properly')
        dx = self.end.x - self.start.x
        dy = self.end.y - self.start.y
        abs_dist = abs(dx) + abs(dy)
        turn_dist = Direction.calc_turns(self.d, dx, dy)
        
        distance = STARTING_POWER - ( abs_dist * STEP_POINT + turn_dist * TURN_POINT)
        print('POWER', distance)
        return