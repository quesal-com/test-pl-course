import json
from util import read_file, write_file

VARIANTS = json.loads(read_file('./variants.json'))
TEMPLATE = read_file('./files/template.puml.txt')

for variant_key, variant in VARIANTS.items():
  content = TEMPLATE.format_map(variant)
  write_file(f'./files/puml/{variant_key}.puml', content)
