

#include <QApplication>
#include <QWidget>
#include <QLabel>

int main(int argc, char *argv[]) {
    QApplication app(argc, argv);
    
    QWidget window;
    window.setWindowTitle("Simple Qt5 App");
    
    QLabel *label = new QLabel("Hello World", &window);
    label->setAlignment(Qt::AlignCenter);
    
    window.resize(200, 100);
    window.show();
    
    return app.exec();
}