import Background from "./Background.js";
import Bullet from "./Bullet.js";
import Panel from "./Plane.js";
import StatusPanel from "./StatusPanel.js";

const createElement = (name) => {
  const div = document.createElement("div");
  div.setAttribute("class", name);
  return div;
};

const points = document.createElement("div");
const hp = document.createElement("div");

const panel = new StatusPanel(points, hp);
const background = new Background(
  "white",
  document.querySelector("div.background")
);
const playerPanel = new Plane(
  "Master",
  "black",
  Background.size.height - 40,
  background.size.width - 40
);
