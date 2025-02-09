import random
import turtle

CANVAS_SIZE = 200
STARTS = 20

def generate_random_color():
    r = random.randint(0, 255)
    g = random.randint(0, 255)
    b = random.randint(0, 255)
    return f"#{r:02x}{g:02x}{b:02x}"

def draw(color = 'red', pen_line = 5, use_random_color = True):
    if use_random_color:
        turtle.fillcolor(generate_random_color())
    else:
        turtle.fillcolor(color)
    turtle.begin_fill()
    for _ in range(5):
        turtle.fd(pen_line)
        turtle.left(72)
        turtle.fd(pen_line)
        turtle.right(144)
    turtle.end_fill()
    random_pos()


def random_pos():
    x = random.randint(0, CANVAS_SIZE)
    y = random.randint(0, CANVAS_SIZE)
    turtle.up()
    turtle.goto(x, y)
    turtle.down()

for _ in range(STARTS):
    draw(pen_line=random.randint(10, 30))
