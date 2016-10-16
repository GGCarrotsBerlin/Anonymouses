from category import Category

CATEGORIES = [Category('addiction', ['drugs', 'alco'], 0),
              Category('love', ['boy', 'girl', 'sex'], 0),
              Category('family', ['dad', 'mom'], 0 )]


class Search:
    """
    Search class serch keywords and count it.
    """
    def analize(self, story):
        """
        Analize story base on keywrods in categories.

        :param Stroy story: Story object

        :rtype: Story
        """
        text_words = self.split_story(story.text)
        for word in text_words:
            for category in CATEGORIES:
                for words in category.words:
                    if word == words:
                        story.rank[category.name] +=1
        return story

    def split_story(self, story):
        """
        Split words from story.

        :param str story: Story text

        :rtype:
        """
        words = story.split(' ')
        return words
