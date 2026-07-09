from typing import Callable

# Registry to store commands
registry: dict[str, Callable[[list[str]], None]] = {}


def register(name: str, func: Callable[[list[str]], None]):
    registry[name.lower()] = func


def execute(command: str, args: list[str]):
    func = registry.get(command.lower())
    if func is None:
        print(f"Unknown command: {command}")
        return

    func(args)


# -------------------------
# Commands
# -------------------------

def say_hello(args: list[str]):
    print("Hello! Welcome to the Python demo.")


def add_numbers(args: list[str]):
    if len(args) != 2:
        print("Usage: add <num1> <num2>")
        return

    try:
        a = int(args[0])
        b = int(args[1])
        print(f"Sum = {a + b}")
    except ValueError:
        print("Arguments must be integers.")


def say_joke(args: list[str]):
    print("Why do programmers prefer Python?")
    print("Because they don't like semicolons!")


# -------------------------
# Register commands
# -------------------------

register("hello", say_hello)
register("add", add_numbers)
register("joke", say_joke)

# -------------------------
# Main loop
# -------------------------

while True:
    line = input("> ").strip()

    if line.lower() in ("exit", "quit"):
        break

    if not line:
        continue

    parts = line.split()
    command = parts[0]
    args = parts[1:]

    execute(command, args)
