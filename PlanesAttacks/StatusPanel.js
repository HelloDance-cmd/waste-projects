export default class StatusPanel {
  recordPoints = 0;
  recordHp = 100;

  pointsElement;
  hpElement;
  constructor(pointsElement, hpElement) {
    this.pointsElement = pointsElement;
    this.hpElement = hpElement;

    this.hpElement.innerText = this.recordHp;
    this.pointsElement.innerText = this.recordPoints;
  }

  set points(value) {
    if (value < 0) {
      this.recordPoints = 0;
      return;
    }
    this.pointsElement.innerText = value;
    this.recordPoints = this.recordPoints + value;
  }

  get points() {
    return this.recordPoints;
  }

  set hp(value) {
    if (value < 0) {
      this.recordHp = 0;
      return;
    }

    this.hpElement.innerText = value;
    this.recordHp = value;
  }

  get hp() {
    return this.recordHp;
  }
}
