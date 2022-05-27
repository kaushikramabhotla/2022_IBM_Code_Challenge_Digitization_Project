# -*- coding: utf-8 -*-
"""
Created on Thu May 26 18:35:31 2022

@author: Admin
"""
from flask import Flask, jsonify, request
app = Flask(__name__)

@app.route('/test',methods=['GET','POST'])

def login():
   if request.method == 'POST':
      req_Json = request.json
      name = req_Json['name']
      return jsonify({"response":"Hi"+name})
   else:
      
      return jsonify({"response":"Get Request Called"})

if __name__ == '__main__':
   app.run(debug = True, port=9000)
