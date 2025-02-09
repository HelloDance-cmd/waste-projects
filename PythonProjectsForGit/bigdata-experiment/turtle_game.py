import time
import turtle
from random import randint
turtle.speed("fast")

record_pos = {
    "Player 1": (-500, 100),
    "Player 2": (-500, 0),
    "Player 3": (-500, -100),
    "Player 4": (-500, -200)
}

def darken_hex_color(hex_color, factor=0.5):
    """
    函数用于加深给定的十六进制颜色代码表示的颜色

    参数:
    hex_color (str): 十六进制颜色代码，格式为 #RRGGBB
    factor (float): 加深颜色的系数，默认值为0.8

    返回:
    str: 加深后的十六进制颜色代码
    """
    # 去除十六进制颜色代码开头的 #
    hex_color = hex_color.lstrip('#')

    # 将十六进制颜色代码转换为RGB值
    r = int(hex_color[0:2], 16)
    g = int(hex_color[2:4], 16)
    b = int(hex_color[4:6], 16)

    # 调整RGB值以加深颜色
    r_darkened = max(0, int(r * factor))
    g_darkened = max(0, int(g * factor))
    b_darkened = max(0, int(b * factor))

    # 将调整后的RGB值转换回十六进制颜色代码
    return "#{:02X}{:02X}{:02X}".format(r_darkened, g_darkened, b_darkened)


class Player:
    _speed = 0

    def __init__(self, player_name, pen: turtle.Turtle, color="black"):
        self.name = player_name
        self.pen = pen
        self.pen.shapesize(3, 3)
        self.pen.speed(self._speed)
        self.pen.color(color)
        self.pen.pencolor(darken_hex_color(color))
        self.pen.shape("turtle")
        self.pen.pensize(20)

        self.pen.penup()
        self.pen.goto(record_pos[player_name][0], record_pos[player_name][1])
        self.pen.pendown()

        self.pen.speed(1)
        self._speed = 1

    def move_forward(self, distance: int) -> None: ...


class Turtle(Player):
    def __init__(self, player_name, pen: turtle.Turtle, color="black"):
        super().__init__(player_name, pen, color)
        self.cur_pos = 0

    # @overload
    def move_forward(self, distance: int) -> None:
        self.pen.fd(distance * self._speed)
        self.cur_pos = self.pen.xcor()


if __name__ == '__main__':
    font_family = "MiSans"
    background_color = "#89CA71"
    finish_line = 200  # 终点线的位置

    finish_line_pen = turtle.Pen()
    finish_line_pen.pensize(8)
    finish_line_pen.pencolor("#EBEBEB")
    finish_line_pen.penup()
    finish_line_pen.goto(200, 200)
    finish_line_pen.pendown()
    finish_line_pen.right(90)
    finish_line_pen.forward(500)
    
    turtle.bgcolor(background_color)
    turtle.filling()
    t1 = Turtle("Player 1", turtle.Pen(), "#0DE129")
    t2 = Turtle("Player 2", turtle.Pen(), "#E12D0D")
    t3 = Turtle("Player 3", turtle.Pen(), "#E1730D")
    t4 = Turtle("Player 4", turtle.Pen(), "#E1CF0D")

    turtle.penup()
    turtle.goto(0, 200)
    turtle.pendown()
    turtle.write("3秒后开始游戏", move=False, align="left", font=(font_family, 20, "bold"))
    time.sleep(3)
    turtle.undo()

    while True:
        t1.move_forward(randint(0, 30))
        if t1.cur_pos >= finish_line:
            turtle.goto(0, 200)
            turtle.pendown()
            turtle.write("NO.1: " + t1.name, move=False, align="left", font=(font_family, 20, "bold"))
            break

        t2.move_forward(randint(0, 30))
        if t2.cur_pos >= finish_line:
            turtle.goto(0, 200)
            turtle.pendown()
            turtle.write("NO.1: " + t2.name, move=False, align="left", font=(font_family, 20, "bold"))
            break

        t3.move_forward(randint(0, 30))
        if t3.cur_pos >= finish_line:
            turtle.goto(0, 200)
            turtle.pendown()
            turtle.write("NO.1: " + t3.name, move=False, align="left", font=(font_family, 20, "bold"))
            break

        t4.move_forward(randint(0, 30))
        if t4.cur_pos >= finish_line:
            turtle.goto(0, 200)
            turtle.pendown()
            turtle.write("NO.1: " + t4.name, move=False, align="left", font=(font_family, 20, "bold"))
            break

        time.sleep(0.3)
    print("Over")
    turtle.done()
