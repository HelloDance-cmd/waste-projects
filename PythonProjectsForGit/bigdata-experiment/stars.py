# Author: Kai
# Date: 2024/11/17

"""
大数据课程实验三
    星星绘制
"""
import turtle, math, random

# 绘画闪光线条
line_count = 23  # 线条个数
pre_degree = 360 / line_count  # 每一个线条相差多少度
padding = 80  # 放大圆的半径数值 按 padding 一个单位


def draw_flash_star():
    global line_count, pre_degree, padding

    def _shift_pen_to(x, y):
        turtle.penup()
        turtle.goto(x, y)
        turtle.pendown()

    rand_color = lambda: (random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))  # 生成一个随机颜色

    initial_x, initial_y = -1, -1

    turtle.bgcolor("black")
    pen_size = 100
    pen_weight = 5
    pen_color = "red"
    fill_color = "yellow"

    (cur_x, cur_y) = turtle.position()
    turtle.pensize(pen_weight)
    turtle.pencolor(pen_color)
    turtle.fillcolor(fill_color)

    turtle.begin_fill()
    for _ in range(5):
        turtle.fd(pen_size)
        turtle.left(360 // 5)
        turtle.fd(pen_size)

        if initial_x == -1 and initial_y == -1:
            initial_x, initial_y = turtle.position()

        turtle.right(180 - 36)
    turtle.end_fill()

    turtle.setheading(90)
    turtle.pensize(2)

    expend = padding * 4
    to_radian = lambda theta: theta * math.pi / 180
    diameter = math.sin(to_radian(72)) * (math.cos(to_radian(72)) + 1) * (pen_size << 1) + expend

    r = diameter / 2
    offset_x = cur_x + initial_x
    offset_y = (initial_y - r) - cur_y + expend / 2

    x_fun = lambda theta: r * math.cos(to_radian(theta)) + offset_x
    y_fun = lambda theta: r * math.sin(to_radian(theta)) + offset_y

    turtle.colormode(255)

    _shift_pen_to(x_fun(90), y_fun(90))
    for _ in range(line_count):
        turtle.pencolor(rand_color())
        turtle.fd(pen_size)

        next_deg = turtle.heading() + pre_degree

        turtle.left(pre_degree)
        _shift_pen_to(x_fun(next_deg), y_fun(next_deg))

    turtle.done()

draw_flash_star()
