import Cmd
import os
class shell(Cmd.Cmd):
  
  def default(args):
    prompt = "(shell) => "
    return os.system(args)
  
 shell.Cmdloop()
