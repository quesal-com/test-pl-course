import codecs, random, string

def random_string(length):
  alpha = string.ascii_uppercase
  num = string.digits
  return ''.join(random.choice(alpha + num) for _ in range(length))

def read_file(file):
  return codecs.open(file, 'r').read()

def generate(data):
  watermark = random_string(8)
  src_CoinCollection = read_file('./workspace/main/model/CoinCollection.java')
  src_CoinCollection = src_CoinCollection.replace('ABCDEFG', watermark)
  src_Coin = read_file('./workspace/main/model/Coin.java')
  src_Coin = src_Coin.replace('ABCDEFG', watermark)
  data["params"]["src_CoinCollection"] = src_CoinCollection
  data["params"]["_workspace_files"] = [
    {"name": "main/model/CoinCollection.java", "contents": src_CoinCollection},
    {"name": "main/model/Coin.java", "contents": src_Coin}
  ]

