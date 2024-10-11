echo "Be sure that mkdocs installed & virtual environemnt created"

# pip install mkdocs

echo "Building mkdocs locally"

source doc_venv/bin/activate
echo "Status of activate virtual env $?"

mkdocs serve
echo "Status of mkdocs serve $?"
