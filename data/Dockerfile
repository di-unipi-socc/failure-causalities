FROM python:3


#Install app dependencies
COPY pongFiles/src/requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt


CMD [ "python", "./src/faultApp.py" ]
