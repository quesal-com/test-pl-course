import codecs

def read_file(file):
  return codecs.open(file, 'r').read()

def write_file(filepath, content):
  with open(filepath, 'w', encoding='utf-8') as file:
    file.write(content)
