import sys
from facebook_page_info_scraper import FacebookPageInfoScraper
from flask import Flask, request, jsonify
import logging
import json

logging.basicConfig(filename='mylog.log', level=logging.INFO, format=f'%(asctime)s %(levelname)s '
                                                                     f'%('f'name)s %(threadName)s : %(message)s')

server = Flask(__name__)


def scrap_fb_page(page_to_scrap):
    data = page_to_scrap
    try:
        logging.info(f"Going to scrap fb {data}")
        scraper = FacebookPageInfoScraper(link=data)
        page_info = scraper.get_page_info()
        logging.info(page_info)
        sys.stdout.write(json.dumps(page_info))
    except Exception as e:
        logging.error(f"Error {e}")


@server.route('/', methods=["POST"])
def index():
    if request.method == 'POST':
        data = request.get_json()
        logging.info(f"Going to scrap fb {data.get('link')} {data}")
        try:
            scraper = FacebookPageInfoScraper(link=data.get('link'))
            page_info = scraper.get_page_info()
            logging.info(page_info)
            #sys.stdout.write(json.dumps(page_info))
            return jsonify(page_info), 200
        except Exception as e:
            logging.error(f"Error {e}")
            raise ValueError(f"Error {e}")


if __name__ == "__main__":
    server_port = sys.argv[1]
    # scrap_fb_page(page_to_scrap)
    server.run(host='0.0.0.0', port=server_port, debug=True)
