import os
import shutil

delete_dir = lambda path: shutil.rmtree(path)

def find_designated_name(designated_name: str, base_path: str) -> None:
  full_path = base_path + designated_name
  if os.path.exists(full_path) and os.path.isdir(full_path):
    # print('Deleted path: ', full_path)
    
    try:
      delete_dir(full_path)
    except PermissionError as pe:
      print(full_path, pe.strerror)
  
  directory_names = os.listdir(base_path)
  # print('Found names: ', directory_names)
  
  for dir_name in directory_names:
    if os.path.isdir(base_path + dir_name + '/'):
      # print(base_path + dir_name + '/')
      find_designated_name(designated_name, base_path + dir_name + '/')
  
    


path = 'D:/Projects/'
deleted_dir_name = '.git'

# find_designated_name(deleted_dir_name, path)
paths = [
    "D:/Projects/GitProjects/Mono",
    "D:/Projects/GitProjects/PDF Online",
    "D:/Projects/JavaProjects/Practice/untitled",
    "D:/Projects/PythonProjectsForGit",
    "D:/Projects/ReactProjects/react-learn-app",
    "D:/Projects/VSCodeProjects/web/blogs",
    "D:/Projects/VueProjects/blog",
    "D:/Projects/VueProjects/bookstore",
    "D:/Projects/VueProjects/linyu-client",
    "D:/Projects/WebstormProjects/Practice/vue-learn"
]

remote_repo = "https://github.com/HelloDance-cmd/waste-projects.git"  # 请替换为真实的远程仓库地址

for path in paths:
    command = f"git submodule add {remote_repo} {path}"
    print(command)


