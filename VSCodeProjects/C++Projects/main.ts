interface IMenu {}
class Menus {
  protected menus: {
    "File": IMenu,
    "Edit": IMenu,
    "Selection": IMenu,
    "Go": IMenu,
    [index: string]: IMenu | undefined
  };
  
}