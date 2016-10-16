def analize_text_w(self, text):
    # command line arguments
    dictfile = CATEGORY_LIST
    textfile = self.split_story(text)

    # a = open(textfile)
    # text = string.split(a.read())  # lowercase the text
    # a.close()
    #
    # a = open(dictfile)
    # lines = a.readlines()
    # a.close()

    dic = {}
    scores = {}
    categories = []

    # a default category for simple word lists
    current_category = "Default"
    scores[current_category] = 0

    # inhale the dictionary
    for category_name in CATEGORY_DICT.keys():
        categories.append(category_name)
    print(CATEGORY_DICT.values())
    # for category in CATEGORY_DICT.values():
    #     print (category)

    # for category in CATEGORY_DICT.keys():
    #     current_category = category
    #     scores[current_category] = 0
    #     # print(current_category)
    #     print(CATEGORY_DICT[category])
    # if cat[] == '>>':
    #     current_category = string.strip(line[2:])
    #     scores[current_category] = 0
    # else:
    #     line = line.strip()
    #     if len(line) > 0:
    #         pattern = re.compile(line, re.IGNORECASE)
    #         dic[pattern] = current_category

    # examine the text
    # for token in text:
    #     for pattern in dic.keys():
    #         if pattern.match(token):
    #             categ = dic[pattern]
    #             scores[categ] = scores[categ] + 1
    #
    # for key in scores.keys():
    #     print key, ":", scores[key]
