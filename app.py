
from flask import Flask, Response, abort

app = Flask(__name__)

PRACTICALS = {
    1: "Exp1_Calculator.java",
    2: "Exp2_Overloading.java",
    3: "Exp3_2D_Array.java",
    4: "Exp4_Inheritance.java",
    5: "Exp5_Overriding.java",
    6: "Exp6_Interfaces.java",
    7: "Exp7_Exception_Hand.java",
    8: "Exp8_Multithreading.java",
    9: "Exp9_Collection_Framework.java",
    10: "Exp10_JDBC_CRUD.java"
}


@app.route("/")
def home():
    return """
    <h1>Java DSCloud</h1>
    <p>Java Practical Code Repository</p>
    <a href="/t/0">View Practical Index</a>
    """


@app.route("/health")
def health():
    return {"status": "OK"}


@app.route("/t/0")
def index():
    result = "JAVA DSCloud - Practical Index\n\n"

    for number, filename in PRACTICALS.items():
        result += f"{number}. {filename} - /t/{number}\n"

    return Response(result, mimetype="text/plain")


@app.route("/t/<int:number>")
def get_practical(number):
    filename = PRACTICALS.get(number)

    if filename is None:
        abort(404, description="Practical not found")

    try:
        with open(filename, "r", encoding="utf-8") as file:
            code = file.read()

        return Response(code, mimetype="text/plain")

    except FileNotFoundError:
        abort(404, description="Code file not found")
