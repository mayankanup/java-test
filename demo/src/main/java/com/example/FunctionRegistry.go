package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// Command represents a callable function.
type Command func(args []string)

// Registry stores all available commands.
var registry = make(map[string]Command)

// Register adds a new command to the registry.
func Register(name string, cmd Command) {
	registry[strings.ToLower(name)] = cmd
}

// Execute runs a command if it exists.
func Execute(name string, args []string) error {
	cmd, exists := registry[strings.ToLower(name)]
	if !exists {
		return fmt.Errorf("unknown command: %s", name)
	}

	cmd(args)
	return nil
}

func sayHello(args []string) {
	fmt.Println("Hello! Welcome to the Go demo.")
}

func addNumbers(args []string) {

	if len(args) != 2 {
		fmt.Println("usage: add <a> <b>")
		return
	}

	a, err := strconv.Atoi(args[0])
	if err != nil {
		fmt.Println("Invalid first number")
		return
	}

	b, err := strconv.Atoi(args[1])
	if err != nil {
		fmt.Println("Invalid second number")
		return
	}

	fmt.Printf("Sum = %d\n", a+b)
}

func sayJoke(args []string) {
	fmt.Println("Why do programmers love Go?")
	fmt.Println("Because it has no class!")
}

func main() {

	// Register commands
	Register("hello", sayHello)
	Register("add", addNumbers)
	Register("joke", sayJoke)

	fmt.Println("Available commands:")
	for cmd := range registry {
		fmt.Printf("- %s\n", cmd)
	}

	fmt.Print("\nEnter command: ")

	reader := bufio.NewReader(os.Stdin)

	fmt.Print("> ")
	line, _ := reader.ReadString('\n')

	parts := strings.Fields(line)

	if len(parts) == 0 {
		return
	}

	command := parts[0]
	args := parts[1:]

	if err := Execute(command, args); err != nil {
		fmt.Println(err)
	}
}
