import unittest
from src.point import Direction

class TestDirection(unittest.TestCase):
    def test_direction_string(self):
        dir_obj = Direction()
        dir_obj.direction = 'N'
        self.assertEqual(dir_obj.direction, 0)

    def test_direction_integer(self):
        dir_obj = Direction()
        dir_obj.direction = 2
        self.assertEqual(dir_obj.direction, 2)

    def test_invalid_direction(self):
        dir_obj = Direction()
        with self.assertRaises(ValueError):
            dir_obj.direction = 'XYZ'

    def test_invalid_integer_direction(self):
        dir_obj = Direction()
        with self.assertRaises(ValueError):
            dir_obj.direction = 5

    def test_get_turns(self):
        turns = Direction.get_turns(0, 1, 0)
        self.assertIsInstance(turns, list)
        self.assertEqual(len(turns), 1)

    # Add more test methods for other functionality