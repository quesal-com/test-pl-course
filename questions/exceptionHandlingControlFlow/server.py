import random, sys, json
from util import read_file

debug = len(sys.argv) > 1 and sys.argv[1] == 'debug'

VARIANTS = json.loads(read_file('./variants.json'))
LOOP_METHOD_CODE = read_file('./files/loopMethod.java.txt')
THROWING_METHOD_TEMPLATE = read_file('./files/throwingMethod.java.txt')

LETTER_VARIANTS = [
  "ABCDEFGHJ", # v1
  "KLMNOPQRS", # v2
  "123456789"  # v3
]

def generate(data):
  chosen_letters = LETTER_VARIANTS[random.choice([0,1,2])]
  variant_letters = {}
  for index, letter in enumerate("ABCDEFGHJ"):
    variant_letters[letter] = f'[{chosen_letters[index]}]'

  loopMethodCode = LOOP_METHOD_CODE.format_map(variant_letters)
  variant_key = random.choice(list(VARIANTS.keys()))
  variant = VARIANTS[variant_key]
  methodName = variant['method']
  throwingMethodCode = THROWING_METHOD_TEMPLATE.format(
    methodName = methodName,
    exceptionName = variant['exTopLevel']
  )
  answersPart1 = get_all_part1_answers(variant, variant_letters)
  data["params"]["variantKey"] = variant_key
  data["params"]["variantLetters"] = variant_letters
  data["params"]["throwingMethodCode"] = throwingMethodCode
  data["params"]["loopMethodCode"] = loopMethodCode
  data["params"]["answersPart1"] = answersPart1
  data["params"]["methodName"] = methodName
  data["params"]["variant"] = variant

def generate_part1_dropdown_answers(exception_name, correct_answer, variant_letters):
  answers = []
  for option in ['B', 'D', 'F', 'H', 'Nowhere']:
    answer = 'Nowhere' if option == 'Nowhere' else variant_letters[option]
    answers.append({ 'tag': option == correct_answer, 'ans': answer })
  return {
    "exceptionName": exception_name,
    "answers": answers
  }

def get_all_part1_answers(variant, variant_letters):
  correct_answers = {
    "exTopLevel": "H",
    "exMiddleCenter": "F",
    "exMiddleLeft": "D",
    "exBottomRight": "B",
    "exMiddleRight": "Nowhere",
    "exBottomCenter": "Nowhere"
  }
  all_answers = []
  for exception_key in correct_answers.keys():
    correct_answer = correct_answers[exception_key]
    exception_name = variant[exception_key]
    single_dropdown_answers = generate_part1_dropdown_answers(exception_name, correct_answer, variant_letters)
    all_answers.append(single_dropdown_answers)

  random.shuffle(all_answers)
  return all_answers


if debug:
  generate({'params': {}})
