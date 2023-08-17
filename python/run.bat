@echo off

REM pip install -r requirements.txt
python -m geektrust sample_input\input1.txt
python -m geektrust sample_input\input2.txt
python -m geektrust sample_input\input3.txt

python -m unittest discover -v
coverage run -m unittest discover -v