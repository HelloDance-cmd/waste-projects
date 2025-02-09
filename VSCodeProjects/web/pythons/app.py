import tkinter as tk
import math
import random
from math import sinh,cosh,tanh
import sympy as sp
from tkinter import END
from tkinter import ttk
import os
sum = ''
beCleaned = 1
window = tk.Tk()
entry = tk.Entry(width=42,font=("黑体",23),justify='right')
entry2 = tk.Entry(width=27,font=("黑体",23),justify='right')


def about_zz():
    awin = tk.Tk()
    awin.geometry("400x250")
    awin.title("关于作者")
    tk.Label(awin,text="作者：拾捌勒壹",font=("微软雅黑",15)).place(x = 20,y=10)
    tk.Label(awin,text="邮箱：shibaleyi2010@163.com",font=("微软雅黑",15)).place(x = 20,y=50)
    tk.Button(awin,text = "抖音：Elbat",width=16,font=("微软雅黑",15),command = lambda:os.system("start https://www.douyin.com/user/MS4wLjABAAAA5iOAGsYkYOuEKdCV4XhSRVBS8wmxq0aJxqiNHr0hbnw")).place(x = 20,y = 90)
    tk.Button(awin,text = "gitee：拾捌勒壹",width=16,font=("微软雅黑",15),command = lambda:os.system("start https://gitee.com/shibaleyi")).place(x = 20,y = 160)
menubar = tk.Menu(window)
menubar.add_cascade (label="关于",command=about_zz)
menubar.add_cascade (label="帮助")
window.config (menu=menubar)

dict1 = {
    "×":"*",
    "÷":"/",
    "%":"/100",
    "取":"%",
    "余":'',
    "^":"**",
    "e":str(math.e),
    "π":str(math.pi),
}
str_ = str 
def _updata():
    
    entry2.config(state='normal')  
    s1 = entry.get()
    s = ''
    for i in s1:
        if i in dict1:
            s += dict1[i]
        else:
            s+=i
    entry2.delete(0, tk.END)
    try:
        entry2.insert(END, str(eval(s)))
    except:
        entry2.insert(END,"错误")
    entry2.config(state='readonly')
def num(str):
    global point,beCleaned
    if  str == '00'  or str == '0' or str == "000" or str == ")" or str == "%" or str == "取余":
        if entry.get() == "0":
            return
    if str == ".":
        if entry.get() == "0":
            beCleaned = 0
    if str == "Rand":
        str = str_(random.random())
    if beCleaned == 1:
        entry.config(state='normal')
        entry.delete(0,tk.END)
        entry.config(state='readonly')
        beCleaned = 0
    entry.config(state='normal')
    entry.insert(tk.END, str)
    entry.config(state='readonly')
    _updata()

def C():
    global point
    entry.config(state='normal')
    entry.delete(0, tk.END)
    entry.insert(tk.END, "")
    entry.config(state='readonly')
    entry2.config(state='normal')
    entry2.delete(0, tk.END)
    entry2.insert(tk.END, "")
    entry2.config(state='readonly')
    point = 1;
def D():
    global point,beCleaned;
    entry.config(state='normal')
    try:
        if entry.get()[len(entry.get())-1] == ".":
            point = 1;
    except IndexError:
        pass
    entry.delete(len(entry.get())-1)
    if entry.get() == "":
        entry.insert(tk.END, "")
        beCleaned = 1
    entry.config(state='readonly')
def dy():
    _updata()
color_font = "#000000"
color = "#ffffff"
def fun(a): 
    pass
def factorial(n):
    return math.factorial(n)
def sqrt(n):
    return math.sqrt()
def pow_(m,n):
    return pow(n,1/m)
def lg(n):
    return math.log10(n)
def ln(n):
    return math.log(n)
def cot(n):
    n = tan(n)
    return 1/n
import sympy as sp
def tan(x):
    return float(sp.tan(x * sp.pi / 180))

def sin(x):
    return float(sp.sin(x * sp.pi / 180))

def cos(x):
    return float(sp.cos(x * sp.pi / 180)) 
def main():
    window.title("计算器pro")
    window.geometry("705x430")
    window.resizable(0,0)
    entry.place(x = 15,y = 10)
    entry.config(state='normal')
    entry.insert(tk.END, "")
    entry.config(state='readonly')
    entry2.place(x = 250,y = 60)
    entry2.config(state='normal')
    entry2.insert(tk.END, "")
    entry2.config(state='readonly')
    tk.Button(window,bd = 2,text='OFF',command=window.destroy,font=("黑体",20)).place(x = 25,y = 55)
    tk.Button(window,bd = 2,text=' C ',command=C,font=("黑体",20)).place(x = 95,y = 55)
    tk.Button(window,bd = 2,text='<--',command=D,font=("黑体",20)).place(x = 165,y = 55)

    tk.Button(window,bd = 2,text=' 1 ',command=lambda:num("1"),font=("黑体",20)).place(x = 25,y = 115)
    tk.Button(window,bd = 2,text=' 2 ',command=lambda:num("2"),font=("黑体",20)).place(x = 95,y = 115)
    tk.Button(window,bd = 2,text=' 3 ',command=lambda:num("3"),font=("黑体",20)).place(x = 165,y =115)

    tk.Button(window,bd = 2,text=' 4 ',command=lambda:num("4"),font=("黑体",20)).place(x = 25,y =175)
    tk.Button(window,bd = 2,text=' 5 ',command=lambda:num("5"),font=("黑体",20)).place(x = 95,y =175)
    tk.Button(window,bd = 2,text=' 6 ',command=lambda:num("6"),font=("黑体",20)).place(x = 165,y =175)

    tk.Button(window,bd = 2,text=' 7 ',command=lambda:num("7"),font=("黑体",20)).place(x = 25,y =235)
    tk.Button(window,bd = 2,text=' 8 ',command=lambda:num("8"),font=("黑体",20)).place(x = 95,y =235)
    tk.Button(window,bd = 2,text=' 9 ',command=lambda:num("9"),font=("黑体",20)).place(x = 165,y =235)

    tk.Button(window,bd = 2,text=' 0 ',command=lambda:num("0"),font=("黑体",20)).place(x = 25,y =295)
    tk.Button(window,bd = 2,text=' . ',command=lambda:num("."),font=("黑体",20)).place(x = 165,y =355)
    tk.Button(window,bd = 2,text='00 ',command=lambda:num("00"),font=("黑体",20)).place(x = 95,y =295)
    tk.Button(window,bd = 2,text='000',command=lambda:num("000"),font=("黑体",20)).place(x = 165,y =295)

    tk.Button(window,bd = 2,text=' + ',command=lambda:num("+"),font=("黑体",20)).place(x = 235,y =115)
    tk.Button(window,bd = 2,text=' - ',command=lambda:num("-"),font=("黑体",20)).place(x = 235,y =175)
    tk.Button(window,bd = 2,text='× ',command=lambda:num("×"),font=("黑体",20)).place(x = 235,y =235)
    tk.Button(window,bd = 2,text='÷ ',command=lambda:num("÷"),font=("黑体",20)).place(x = 235,y =295)
    tk.Button(window,bd = 2,text=' = ',command=dy,font=("黑体",20)).place(x = 235,y =355)

    tk.Button(window,bd = 2,text=' % ',command=lambda:num("%"),font=("黑体",20)).place(x = 305,y =115)
    tk.Button(window,bd = 2,text='π ',command=lambda:num("π"),font=("黑体",20)).place(x = 305,y =175)
    tk.Button(window,bd = 2,text=' e ',command=lambda:num("e"),font=("黑体",20)).place(x = 305,y =235)
    tk.Button(window,bd = 2,text='|x|',command=lambda:num("abs("),font=("黑体",20)).place(x = 305,y =295)
    tk.Button(window,bd = 2,text='e^x',command=lambda:num("e^"),font=("黑体",20)).place(x = 305,y =355)

    tk.Button(window,bd = 2,text='x^2',command=lambda:num("^2"),font=("黑体",20)).place(x = 375,y =115)
    tk.Button(window,bd = 2,text='x^3',command=lambda:num("^3"),font=("黑体",20)).place(x = 375,y =175)
    tk.Button(window,bd = 2,text='x^n',command=lambda:num("^"),font=("黑体",20)).place(x = 375,y =235)
    tk.Button(window,bd = 2,text='10^n',command=lambda:num("10^"),font=("黑体",20)).place(x = 515,y =355)
    tk.Button(window,bd = 2,text='1/x',command=lambda:num("1÷"),font=("黑体",20)).place(x = 375,y =295)
    tk.Button(window,bd = 2,text='n！',command=lambda:num("factorial("),font=("黑体",20)).place(x = 375,y =355)

    tk.Button(window,bd = 2,text='√ ',command=lambda:num("sqrt("),font=("黑体",20)).place(x = 445,y =115)
    tk.Button(window,bd = 2,text='³√',command=lambda:num("pow_(3,"),font=("黑体",20)).place(x = 445,y =175)
    tk.Button(window,bd = 2,text='4√',command=lambda:num("pow_(4,"),font=("黑体",20)).place(x = 445,y =235)
    tk.Button(window,bd = 2,text='lg ',command=lambda:num("lg("),font=("黑体",20)).place(x = 445,y =295)
    tk.Button(window,bd = 2,text='ln ',command=lambda:num("ln("),font=("黑体",20)).place(x = 445,y =355)

    tk.Button(window,bd = 2,text='sin ',command=lambda:num("sin("),font=("黑体",20)).place(x = 515,y =115)
    tk.Button(window,bd = 2,text='cos ',command=lambda:num("cos("),font=("黑体",20)).place(x = 515,y =175)
    tk.Button(window,bd = 2,text='tan ',command=lambda:num("tan("),font=("黑体",20)).place(x = 515,y =235)
    tk.Button(window,bd = 2,text='cot ',command=lambda:num("cot("),font=("黑体",20)).place(x = 515,y =295)

    tk.Button(window,bd = 2,text='sinh',command=lambda:num("sinh("),font=("黑体",20)).place(x = 602,y =115)
    tk.Button(window,bd = 2,text='cosh',command=lambda:num("cosh("),font=("黑体",20)).place(x = 602,y =175)
    tk.Button(window,bd = 2,text='tanh',command=lambda:num("tanh("),font=("黑体",20)).place(x = 602,y =235)
    tk.Button(window,bd = 2,text='取余',command=lambda:num("取余"),font=("黑体",20)).place(x = 602,y =355)
    tk.Button(window,bd = 2,text='Rand',command=lambda:num("Rand"),font=("黑体",20)).place(x = 602,y =295)

    tk.Button(window,bd = 2,text=' (',command=lambda:num("("),font=("黑体",20)).place(x = 25,y =355)
    tk.Button(window,bd = 2,text=') ',command=lambda:num(")"),font=("黑体",20)).place(x = 105,y =355)
    window.mainloop()

if __name__ == "__main__":
    main()