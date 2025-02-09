export default class Bullet {
  x;
  y;
  color;

  element;
  size = {
    width: 0,
    height: 0,
  };

  constructor(x, y, color, element, size) {
    this.x = x;
    this.y = y;
    this.color = color;

    this.element = element;
    this.size = size;

    this.element.style.x = x + "px";
    this.element.style.y = y + "px";
    this.element.style.width = this.size.width + "px";
    this.element.style.height = this.size.height + "px";
  }

  moveLeft(pre) {
    this.x = Math.max(Background.size.height, this.x - pre);

    element.style.left = x + "px";
  }

  moveRight(pre) {
    this.x = Math.max(Background.size.height, this.x + pre);

    element.style.left = x + "px";
  }

  moveUp(pre) {
    this.y = Math.max(Background.size.width, this.y - pre);

    element.style.top = y + "px";
  }

  moveDown(pre) {
    this.y = Math.max(Background.size.width, this.y + pre);

    element.style.top = y + "px";
  }
}
