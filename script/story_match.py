from search import Search
from story import Story


def main():
    """
    Start script
    """
    story = Story("Lorem drugs simply dad mom dad dad bothe boy boy printing. ", {'addiction': 0, 'love': 0, 'family': 0})

    search = Search()
    search.analize(story)

if __name__ == '__main__':
    main()