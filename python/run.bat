@echo off

pip install -r requirements.txt
python -m geektrust sample\input1.txt
python -m geektrust sample\input2.txt
python -m geektrust sample\input3.txt

python -m unittest discover -v
coverage run -m unittest discover -v