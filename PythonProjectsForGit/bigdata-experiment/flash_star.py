import math
import turtle
from random import randint


class StarDrawer:
    _DEFAULT_BACKGROUND = 'black'  # 默认画板背景
    _DEFAULT_MAX_PEN_SIZE = 100  # 最大画笔颜色，在满天星的时候有效

    def __init__(self, width=300, height=300, star_count=70, speed = "fast"):
        """
        :param width: 画板宽度
        :param height:  画板高度
        :param star_counts:  星星数量
        :param speed: 绘画速度
        """
        self.width = width
        self.height = height
        self.star_count = star_count
        self.rand_color = lambda: (randint(0, 255), randint(0, 255), randint(0, 255))  # 生成一个随机颜色

        turtle.speed(speed)

    def _draw_a_star(self):
        """
        画一个星，后续如果想多画星星，反复调用该函数即可
        :return:
        """
        pen_size = randint(10, self._DEFAULT_MAX_PEN_SIZE)
        turtle.colormode(255)

        turtle.fillcolor(self.rand_color())

        turtle.begin_fill()
        for _ in range(5):
            turtle.fd(pen_size)
            turtle.left(360 // 5)
            turtle.fd(pen_size)
            turtle.right(180 - 36)
        turtle.end_fill()

    def _shift_pen_to(self, x, y):
        turtle.penup()
        turtle.goto(x, y)
        turtle.pendown()

    def draw_sky_full_of_stars(self):
        # 设置背景颜色
        turtle.bgcolor(self._DEFAULT_BACKGROUND)
        rand_points = lambda: (randint(0, self.width), randint(0, self.height))

        for _ in range(self.star_count):
            (x, y) = rand_points()
            self._draw_a_star()
            self._shift_pen_to(x, y)

    def adjust_pen_size(self, size: int):
        self._DEFAULT_MAX_PEN_SIZE = size

    def draw_flash_star(self):
        initial_x, initial_y = -1, -1  # 记录五角星顶点的位置
        # 填充背景颜色
        turtle.bgcolor(self._DEFAULT_BACKGROUND)
        pen_size = 100  # 画笔的长度
        pen_weight = 5  # 画笔粗细
        pen_color = "red"  # 画笔颜色
        fill_color = "yellow"  # 填充颜色

        (cur_x, cur_y) = turtle.position()  # 记录画笔开始位置
        # 开始画图
        # 设置初始值
        turtle.pensize(pen_weight)
        turtle.pencolor(pen_color)
        turtle.fillcolor(fill_color)

        turtle.begin_fill()
        for _ in range(5):
            turtle.fd(pen_size)
            turtle.left(360 // 5)
            turtle.fd(pen_size)

            # TODO: 记录最高端点位置以便于计算半径
            if initial_x == -1 and initial_y == -1:
                initial_x, initial_y = turtle.position()

            turtle.right(180 - 36)
        turtle.end_fill()

        # 绘画闪光线条
        line_count = 23 # 线条个数
        pre_degree = 360 / line_count  # 每一个线条相差多少度
        padding = 40  # 放大圆的半径数值 按 padding 一个单位

        # 回到默认位置
        turtle.setheading(90)
        turtle.pensize(2)

        expend = padding * 4  # 扩大倍数
        
        # 角度转弧度
        to_radian = lambda theta: theta * math.pi / 180

        # 直径
        diameter = math.sin(to_radian(72)) * (math.cos(to_radian(72)) + 1) * (pen_size << 1) + expend

        # 计算半径、原点偏移量
        r = diameter / 2
        offset_x = cur_x + initial_x
        offset_y = (initial_y - r) - cur_y + expend / 2

        x_fun = lambda theta: r * math.cos(to_radian(theta)) + offset_x
        y_fun = lambda theta: r * math.sin(to_radian(theta)) + offset_y

        turtle.colormode(255) # 更改最大颜色数值显示 0..colormode

        self._shift_pen_to(x_fun(90), y_fun(90))
        for _ in range(line_count):
            # 每次画线的时候更改颜色
            turtle.pencolor(self.rand_color())
            turtle.fd(pen_size)

            next_deg = turtle.heading() + pre_degree

            turtle.left(pre_degree)
            self._shift_pen_to(x_fun(next_deg), y_fun(next_deg))


if __name__ == '__main__':
    start_drawer = StarDrawer(star_count=30)
    # 一闪一闪亮晶晶
    start_drawer.draw_flash_star()
    # 满天星
    # start_drawer.draw_sky_full_of_stars()

    turtle.done()

