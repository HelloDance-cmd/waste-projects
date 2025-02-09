export default class Background {
  static size = {
    width: 1000,
    height: 700,
  };

  element;
  constructor(color = "#ccc", element) {
    this.color = color;

    this.element = element;

    this.element.style.width = Background.size.width + "px";
    this.element.style.height = Background.size.height + "px";
    this.element.style.backgroundColor = this.color;
  }
}
