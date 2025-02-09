export default class Plane {
  name;
  color;
  x;
  y;
  size = {
    width: 0,
    height: 0,
  };

  element;

  constructor(name, color, x, y, size, element) {
    this.name = name;
    this.color = color;
    this.x = x;
    this.y = y;
    this.size = size;

    this.element = element;

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
